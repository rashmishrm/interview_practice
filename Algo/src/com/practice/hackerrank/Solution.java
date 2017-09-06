package com.practice.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	static class TweetEntry implements Comparable<TweetEntry> {

		int tweetid;
		int frequency;

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return tweetid * 31;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return this.tweetid == ((TweetEntry) obj).tweetid;
		}

		@Override
		public int compareTo(TweetEntry o) {
			// TODO Auto-generated method stub
			return this.frequency - o.frequency;
		}

	}

	/*
	 * Complete the function below.
	 */
	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser,
			int minLikeThreshold) {

		Map<Integer, List<Integer>> followList = new HashMap<>();

		for (int i = 0; i < followGraph_edges.length; i++) {

			if (followList.containsKey(followGraph_edges[i][0])) {
				followList.get(followGraph_edges[i][0]).add(followGraph_edges[i][1]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(followGraph_edges[i][1]);
				followList.put(followGraph_edges[i][0], list);
			}

		}

		// cpnvert like to adjancy list

		Map<Integer, List<Integer>> likeList = new HashMap<>();

		for (int i = 0; i < likeGraph_edges.length; i++) {

			if (likeList.containsKey(likeGraph_edges[i][0])) {
				likeList.get(likeGraph_edges[i][0]).add(likeGraph_edges[i][1]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(likeGraph_edges[i][1]);
				likeList.put(likeGraph_edges[i][0], list);
			}

		}

		// get all user's whom target user follows

		List<Integer> followingList = followList.get(targetUser);

		Map<Integer, TweetEntry> tweetMap = new HashMap<>();

		for (Integer follow : followingList) {

			List<Integer> list = likeList.get(follow);

			for (Integer tweet : list) {

				if (tweetMap.containsKey(tweet)) {

					TweetEntry tw = tweetMap.get(tweet);
					tw.frequency = tw.frequency + 1;
				} else {
					TweetEntry t = new TweetEntry();
					t.tweetid = tweet;
					t.frequency = 1;

					tweetMap.put(tweet, t);
				}

			}

		}

		// sorting

		List<TweetEntry> tList = new ArrayList<TweetEntry>(tweetMap.values());

		Collections.sort(tList);

		List<Integer> tweetList = new ArrayList<>();

		for (TweetEntry entry : tList) {

			if (entry.frequency >= minLikeThreshold)
				tweetList.add(entry.tweetid);
		}

		int[] array = new int[tweetList.size()];

		for (int j = 0; j < tweetList.size(); j++) {
			array[j] = tweetList.get(j);
		}

		return array;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = "output";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int[] res;

		String[] _followGraph_nodesm = in.nextLine().split(" ");
		int _followGraph_nodes = Integer.parseInt(_followGraph_nodesm[0]);
		int _followGraph_edges = Integer.parseInt(_followGraph_nodesm[1]);

		int[] _followGraph_from = new int[_followGraph_edges];
		int[] _followGraph_to = new int[_followGraph_edges];

		for (int _followGraph_i = 0; _followGraph_i < _followGraph_edges; _followGraph_i++) {
			String[] _followGraph_fromv = in.nextLine().split(" ");
			_followGraph_from[_followGraph_i] = Integer.parseInt(_followGraph_fromv[0]);
			_followGraph_to[_followGraph_i] = Integer.parseInt(_followGraph_fromv[1]);
		}

		String[] _likeGraph_nodesm = in.nextLine().split(" ");
		int _likeGraph_nodes = Integer.parseInt(_likeGraph_nodesm[0]);
		int _likeGraph_edges = Integer.parseInt(_likeGraph_nodesm[1]);

		int[] _likeGraph_from = new int[_likeGraph_edges];
		int[] _likeGraph_to = new int[_likeGraph_edges];

		for (int _likeGraph_i = 0; _likeGraph_i < _likeGraph_edges; _likeGraph_i++) {
			String[] _likeGraph_fromv = in.nextLine().split(" ");
			_likeGraph_from[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[0]);
			_likeGraph_to[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[1]);
		}

		// generate follow Graph
		int[][] followGraph = new int[_followGraph_edges][2];
		for (int i = 0; i < _followGraph_edges; i++) {
			followGraph[i][0] = _followGraph_from[i];
			followGraph[i][1] = _followGraph_to[i];
		}
		// generate like Graph
		int[][] likeGraph = new int[_likeGraph_edges][2];
		for (int i = 0; i < _likeGraph_edges; i++) {
			likeGraph[i][0] = _likeGraph_from[i];
			likeGraph[i][1] = _likeGraph_to[i];
		}
		int _targetUser;
		_targetUser = Integer.parseInt(in.nextLine().trim());

		int _minLikeThreshold;
		_minLikeThreshold = Integer.parseInt(in.nextLine().trim());

		res = getRecommendedTweets(followGraph, likeGraph, _targetUser, _minLikeThreshold);
		if (res == null) {
			bw.write("Null Result");
			bw.newLine();
			bw.close();
			return;
		}
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}
		bw.close();
	}
}
