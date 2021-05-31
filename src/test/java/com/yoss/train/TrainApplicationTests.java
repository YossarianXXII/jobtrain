package com.yoss.train;

import com.yoss.train.algorithms.CountingAlgorithm;
import com.yoss.train.algorithms.DoubleRun;
import com.yoss.train.algorithms.SimpleRun;
import com.yoss.train.algorithms.Statistics;
import com.yoss.train.train.Train;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SpringBootTest
class TrainApplicationTests {

	Logger LOG = Logger.getLogger(TrainApplicationTests.class.getName());

	int execute(Train t, CountingAlgorithm c){
		return c.count(t);
	}

	@Test
	void testSimple(){
		Train t = new Train(1);
		CountingAlgorithm run = new SimpleRun();
		int calculatedSize = execute(t, run);

		Assertions.assertTrue(t.checkSize(calculatedSize));
		LOG.info(run.getStatistics().toString());
	}

	@Test
	void testDouble(){
		Train t = new Train(1);
		DoubleRun run = new DoubleRun();
		int result = execute(t, run);

		Assertions.assertTrue(t.checkSize(result));
		LOG.info(run.getStatistics().toString());
	}

	@Test
	void multiTestSimple(){
		Map<Integer, Statistics> results = new LinkedHashMap<>();

		for(int i = 1; i < 100000; i*=2){
			Train t = new Train(i);
			CountingAlgorithm run = new SimpleRun();
			int calculated = execute(t, run);
			Assertions.assertTrue(t.checkSize(calculated));
			results.put(i, run.getStatistics());
		}

		results.forEach((integer, statistics) -> LOG.info("{" + integer + "," + statistics + "}"));
	}

	@Test
	void multiTestDouble(){
		Map<Integer, Statistics> results = new LinkedHashMap<>();
		for(int i = 1; i < 10000000; i*=3){
			CountingAlgorithm run = new DoubleRun();
			Train t = new Train(i);
			int calculated = execute(t, run);
			Assertions.assertTrue(t.checkSize(calculated));
			results.put(i, run.getStatistics());
		}

		results.forEach((integer, statistics) -> LOG.info("{" + integer + "," + statistics + "}"));
	}


	//
	// unfinished try-outs after this warning
	//

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


	private List<Statistics> testNtimes(int n, int size, CountingAlgorithm c){
		List<Statistics> results = new ArrayList<>(size);
		for (int i = 0; i < n; i++) {
			Train t = new Train(size);
			c.count(t);
			results.add(c.getStatistics());
		}
		return results;
	}

}
