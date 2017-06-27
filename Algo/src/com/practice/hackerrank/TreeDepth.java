package com.practice;

import java.util.*;
import java.io.*;

public class TreeDepth {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		
		
	

		
		
		int computeHeight() {
			// Replace this code with a faster implementation

			HashMap<Integer, Set<Integer>> mapSet = new HashMap<Integer, Set<Integer>>();
			
			
			HashMap<Integer,Integer> parentMap= new HashMap<>();
			int root=0;
			for (int i = 0; i < n; i++) {

				int value =  parent[i];

				if(value==-1){
					root=i;
				}
				
				if (mapSet.containsKey(value)) {

					mapSet.get(value).add(i);

				} else {
					Set<Integer> set = new HashSet<>();
					set.add(i);
					mapSet.put(value, set);

				}
				
				parentMap.put(i, parent[i]);

			}

			
			
			//System.out.println(mapSet);
			int depth=1;

			Set<Integer> children=mapSet.get(root);
			
		
			
			List<Integer> bss=new ArrayList<Integer>();
			bss.add(root);
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.add(root);
			
			int last=0;
			while (!q.isEmpty()) {
				Integer n = (Integer) q.remove();
				last=n;
				//System.out.println(n);
				if(mapSet.get(n)!=null){
				q.addAll(mapSet.get(n));
				}
				
			}
			
			int next= parentMap.get(last);
			
			while(next!=-1){
				
				next= parentMap.get(next);
				depth++;
				
			}
			
			//System.out.println(last);
			
			
		
			return depth;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new TreeDepth().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}