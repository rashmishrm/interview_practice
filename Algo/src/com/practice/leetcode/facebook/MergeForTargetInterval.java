package com.practice.leetcode.facebook;

public class MergeForTargetInterval {
	Arrays.sort(list, new Comparator<Interval>(){
		public int compare(Interval a, Interval b) {
			if (a.start != b.start) {
				return a.start - b.start;
			}
			return a.end - b.end;
		}
	});
	
	int num = 0, i = 0, start = interval.start, end = -1;
	while (i < list.length) {
		if (list[i].end <= start) {
			i++;
		} else {
			if (list[i].start > start) break;
			while (i < list.length && list[i].start < start) {
				end = Math.max(end, list[i].end);
				i++;
			}
			if (start != end) {
				num++;
				start = end;
			}
		}
	}
	
	if (end < interval.end)
		return 0;
	return num;
}
