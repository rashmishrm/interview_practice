package com.practice.coursera;




import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class HashChains {

	private FastScanner in;
	private PrintWriter out;
	// store all strings in one list
	private Map<Integer,LinkedList<String>> elems = null;

	// for hash function
	private int bucketCount;
	private int prime = 1000000007;
	private int multiplier = 263;

	public static void main(String[] args) throws IOException {
		new HashChains().processQueries();
	}

	private int hashFunc(String s) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; --i)
			hash = (hash * multiplier + s.charAt(i)) % prime;
		return (int) hash % bucketCount;
	}

	private Query readQuery() throws IOException {
		String type = in.next();
		if (!type.equals("check")) {
			String s = in.next();
			return new Query(type, s);
		} else {
			int ind = in.nextInt();
			return new Query(type, ind);
		}
	}

	private void writeSearchResult(boolean wasFound) {
		out.println(wasFound ? "yes" : "no");
		// Uncomment the following if you want to play with the program
		// interactively.
		// out.flush();
	}

	public boolean find(String str) {
		boolean found = false;
		int hashcode = hashFunc(str);
		LinkedList<String> list = elems.get(hashcode);
		if(list!=null){
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			if (i.next().equals(str)) {
				found = true;
				break;
			}
		}
		}
		return found;
	}

	public void add(String str) {

		if (!find(str)) {
			int hashcode = hashFunc(str);
			LinkedList<String> list = elems.get(hashcode);
			if (list == null) {
				list = new LinkedList<String>();
				
				elems.put(hashcode,list);
			}
			list.addFirst(str);
		}

	}

	public void delete(String str) {
		boolean found = false;
		int hashcode = hashFunc(str);
		LinkedList<String> list = elems.get(hashcode);
		if(list!=null){
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			if (i.next().equals(str)) {
				found = true;
				break;
			}
		}
		if (found) {
			i.remove();
		}
		}
	}

	public LinkedList<String> check(int in) {

		boolean found = false;

		LinkedList<String> list = elems.get(in);
		return list;

	}

	private void processQuery(Query query) {
		switch (query.type) {
		case "add":
			add(query.s);
			break;
		case "del":
			delete(query.s);
			break;
		case "find":
			boolean found = find(query.s);
			writeSearchResult(found);
			break;
		case "check":
			LinkedList<String> list = check(query.ind);
			if(list!=null){
			for (String cur : list)
			 out.print(cur + " ");
			}
			out.println(" ");
			
			// Uncomment the following if you want to play with the program
			// interactively.
			// out.flush();
			break;
		default:
			throw new RuntimeException("Unknown query: " + query.type);
		}
	}

	public void processQueries() throws IOException {
		elems = new HashMap<>();
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		bucketCount = in.nextInt();
	
		
		
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i) {
			processQuery(readQuery());
		}
		out.close();
	}

	static class Query {
		String type;
		String s;
		int ind;

		public Query(String type, String s) {
			this.type = type;
			this.s = s;
		}

		public Query(String type, int ind) {
			this.type = type;
			this.ind = ind;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
