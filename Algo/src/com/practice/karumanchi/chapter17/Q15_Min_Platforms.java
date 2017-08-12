package com.practice.karumanchi.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q15_Min_Platforms {

	public static int minPlatforms(List<Time> list) {
		int platforms = 0;
		TrainTime arr[] = new TrainTime[2 * list.size()];
		int j = 0;
		for (int i = 0; i < (list.size()); i++) {
			arr[j] = new TrainTime(list.get(i).startTime, 0);
			arr[j + 1] = new TrainTime(list.get(i).endTime, 1);
			j = j + 2;

		}

		Arrays.sort(arr, new Comparator<TrainTime>() {

			@Override
			public int compare(TrainTime o1, TrainTime o2) {

				return o1.time - o2.time;
			}
		});
		int max = 0;

		for (TrainTime time : arr) {
			if (time.type == 0) {
				platforms++;
			} else {
				platforms--;
			}

			if (max < platforms) {
				max = platforms;
			}
		}

		return max;

	}

	public static void main(String[] args) {
		List<Time> list = new ArrayList<>();
		list.add(new Time(10, 12));
		list.add(new Time(12, 14));

		list.add(new Time(9, 11));

		list.add(new Time(8, 10));

		list.add(new Time(11, 12));

		list.add(new Time(6, 12));

		System.out.println(minPlatforms(list));
	}
}

class TrainTime {
	int time;
	int type;

	public TrainTime(int time, int type) {
		super();
		this.time = time;
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return time + "::" + type;
	}
}
