package com.yoss.train;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class TrainApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSimple(){
		Train t = new Train(10);
		CountingAlgorithm c = new SimpleRun();

		int calculatedSize = c.count(t);

		Assertions.assertTrue(t.checkSize(calculatedSize));
		System.out.println(t.statistics);
	}


	@Test
	void averageSimple(){
		int length = 10;
		List<Statistics> results = testNtimes(100, length, new SimpleRun());
		int averageMoves = average(results.stream().map(e -> e.movesCount).collect(Collectors.toList()));
		System.out.println(String.format("Average moves needed for train length of %d is: %d", length, (int)averageMoves));
		System.out.println(results);
	}

	private int average(List<Integer> allRuns) {
		Integer sum = allRuns.stream().reduce(0, (a, b) -> a + b);
		return sum /allRuns.size();
	}


	@org.jetbrains.annotations.NotNull
	private List<Statistics> testNtimes(int n, int size, CountingAlgorithm c){
		List<Statistics> results = new ArrayList<>(size);
		for (int i = 0; i < n; i++) {
			Train t = new Train(size);
			c.count(t);
			results.add(t.statistics);
		}
		return results;
	}

}
