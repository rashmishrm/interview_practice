package com.practice.leetcode.tree;

import java.util.*;

public class Solution {
	private static final Random r = new Random(3);
	private static final boolean STRICT = true; // Set to "true" to verify cache behavior.

	public static class Database {
		private TreeSet<Integer> data;

		public Database() {
			data = new TreeSet<>();
		}

		public List<Integer> getRange(int begin, int end, boolean log) {
			if (log) {
				System.out.printf("\nquerying db: %d - %d\n", begin, end);
			}
			return new ArrayList<>(data.subSet(begin, end));
		}

		public List<Integer> getRange(int begin, int end) {
			return getRange(begin, end, true);
		}

		public void populateTestData() {
			for (int i = 0; i < 10; i++) {
				data.add(r.nextInt(20));
			}

			System.out.print("\ndatabase contents:\n");
			for (Integer elem : data) {
				System.out.printf("  %d\n", elem);
			}
		}
	}

	public static class CachedDatabase {
		private Database db; // underlying data store

		// Schema: [begin, end)
		// rangeBound => true if range bound begins a present range
		// false if range bound ends a present range
		private TreeMap<Integer, Boolean> rangeCache;
		private TreeSet<Integer> valueCache; // Cached values.

		public CachedDatabase(Database db) {
			this.db = db;
			this.rangeCache = new TreeMap<>();
			this.valueCache = new TreeSet<>();
		}

		public List<Integer> getRange(int begin, int end) {
			// Ensure that the cache includes the range.
			populateCache(begin, end);

			// Read the required range out of the set.
			return new ArrayList<>(valueCache.subSet(begin, end));
		}

		private void populateCache(int begin, int end) {

			// TreeSet<Integer[]> set = new TreeSet<Integer[]>();

			NavigableMap<Integer, Boolean> interiorMap = rangeCache.subMap(begin, true, end, true);

			//System.out.println(interiorMap.size());
			//Integer lastTrue = null;
			Integer lastFalse = null;

			if (interiorMap.isEmpty()) {
				updateCache(begin, end, db.getRange(begin, end));
			}
			Integer nearestStart = interiorMap.firstKey();
			Integer nearestEnd = interiorMap.lastKey();
			List<int[]> rangesToQuery = new ArrayList<>();

			for (Map.Entry<Integer, Boolean> entry : interiorMap.entrySet()) {

				if (entry.getValue() == true && lastFalse != null) {

					if (lastFalse != entry.getKey()) {

						rangesToQuery.add(new int[] { lastFalse, entry.getKey() });
						//System.out.println(rangesToQuery.size());

					}
				}

				if (!entry.getValue()) {
					
					lastFalse = entry.getKey();
				}
			}

			for (int[] ranges : rangesToQuery) {

				updateCache(ranges[0], ranges[1], db.getRange(ranges[0], ranges[1]));

			}

			//System.out.println(interiorMap.size());

			if (begin != nearestStart && begin < nearestStart) {

				updateCache(begin, nearestStart, db.getRange(begin, nearestStart));

			}

			if (nearestEnd != end && nearestEnd < end) {

				updateCache(nearestEnd, end, db.getRange(nearestEnd, end));
			}

			/**********
			 *
			 * YOUR CODE WILL GO HERE
			 *
			 ***********/
		}

		public void printCacheContents() {
			System.out.print("\nrange cache:\n");
			for (Map.Entry<Integer, Boolean> rangeEntry : rangeCache.entrySet()) {
				System.out.printf("  %d -> %b\n", rangeEntry.getKey(), rangeEntry.getValue());
			}

			System.out.print("\nvalue cache:\n");
			for (Integer value : valueCache) {
				System.out.printf("  %d\n", value);
			}
		}

		// Updates rangeCache to include the range [begin, end)
		// Allows overlap with previously added ranges
		// Updates valueCache to contain values.
		private void updateCache(int begin, int end, List<Integer> values) {
			if (begin >= end)
				return; // Don't bother with these degenerate cases.

			// Clear out everything between the endpoints (inclusively)
			NavigableMap<Integer, Boolean> interiorMap = rangeCache.subMap(begin, true, end, true);
			interiorMap.clear();

			// Update the endpoints.
			Map.Entry<Integer, Boolean> entryBefore = rangeCache.lowerEntry(begin);
			Map.Entry<Integer, Boolean> entryAfter = rangeCache.higherEntry(end);

			// Either nothing before the beginning or the last key ends a range.
			if (entryBefore == null || !entryBefore.getValue()) {
				rangeCache.put(begin, true);
			}

			// Either nothing after or the next key begins a range.
			if (entryAfter == null || entryAfter.getValue()) {
				rangeCache.put(end, false);
			}

			if (STRICT) {
				// Cache should never add the same value twice. Verify for strict mode.
				for (Integer value : values) {
					if (valueCache.contains(value)) {
						throw new IllegalStateException("Read same value twice.");
					}
				}
			}

			// Update value cache.
			valueCache.addAll(values);
		}
	}

	public static void main(String[] args) {
		for (int itr = 0; itr < 1; itr++) { // Increase iteration count get more runs
			Database db = new Database();
			db.populateTestData();

			CachedDatabase cdb = new CachedDatabase(db);

			for (int i = 0; i < 5; i++) {
				int n1 = r.nextInt(20);
				int n2 = r.nextInt(20);

				System.out.printf("\nquery: %d - %d\n", Math.min(n1, n2), Math.max(n1, n2));
				List<Integer> results = cdb.getRange(Math.min(n1, n2), Math.max(n1, n2));

				System.out.print("\nquery results:\n");
				for (Integer result : results) {
					System.out.printf("  %d\n", result);
				}
				cdb.printCacheContents();

				List<Integer> uncachedResults = db.getRange(Math.min(n1, n2), Math.max(n1, n2), false);
				if (!uncachedResults.equals(results)) {
					throw new IllegalStateException("Cached results (" + results + ") did not match uncached results ("
							+ uncachedResults + ")");
				}
			}
		}
	}
}