package Anji;

import java.util.List;

import org.jgap.BulkFitnessFunction;
import org.jgap.Chromosome;

import com.anji.util.Configurable;
import com.anji.util.Properties;

@SuppressWarnings("serial")
public class PacmanFitnessFunction implements BulkFitnessFunction, Configurable {

	private int numberOfThreads;
	private int maxFitness;
	private Properties properties;

	public PacmanFitnessFunction() {

	}

	@Override
	public void init(Properties properties) throws Exception {
		try{
			numberOfThreads = properties.getIntProperty("threads.count", 4);
			maxFitness = properties.getIntProperty("fitness.max");
			this.properties = properties;
		}catch(Exception e){
			throw new IllegalArgumentException( "invalid properties: " + e.getClass().toString() + ": "
					+ e.getMessage() );
		}
	}

	public void evaluate(@SuppressWarnings("rawtypes") List subjects) {
/*		int i = 0;
		if (subjects.size() < numberOfThreads) {
			numberOfThreads = subjects.size();
		}
		PacmanWorkerThread[] threads = new PacmanWorkerThread[numberOfThreads];
		for (int j = 0; j < numberOfThreads; j++) {
			threads[j] = new PacmanWorkerThread((Chromosome) subjects.get(j));
			threads[j].init(properties);
			threads[j].start();
		}
		i = numberOfThreads;
		while (i < subjects.size()) {
			for (int j = 0; j < numberOfThreads; j++) {
				if (!(threads[j].isAlive())) {
					threads[j] = new PacmanWorkerThread((Chromosome) subjects.get(i));
					threads[j].init(properties);
					threads[j].start();
					i++;
					break;
				}
			}
		}*/
		int current = 0;
		PacmanWorkerThread[] threads = new PacmanWorkerThread[numberOfThreads];
		while (current < subjects.size()) {
			for (int i = 0; i < numberOfThreads; i++) {
				if (threads[i] == null || !threads[i].isAlive()) {
					threads[i] = new PacmanWorkerThread((Chromosome) subjects.get(current));
					threads[i].init(properties);
					threads[i].start();
					current++;
					break;
				}
			}
		}
		for (int j = 0; j < numberOfThreads; j++) {
			try {
				if (threads[j] != null) {
					threads[j].join();
				}
			} catch (InterruptedException e) {
				throw new Error("A thread got interrupted");
			}
		}
	}

	public int getMaxFitnessValue() {
		return maxFitness;
	}

}
