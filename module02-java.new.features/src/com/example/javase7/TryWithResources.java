package com.example.javase7;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class TryWithResources {
	@SuppressWarnings({ "finally", "unused" })
	public static int fun() {
		try {
			if (true)
			   throw new Exception();
			return 42;
		} catch (Exception e) {
			throw e;
			// return 108;
		} finally {
			return 256;
		}
	}

	public static void gun() {
		PreciousResource res1 = new PreciousResource(1);
		PreciousResource res2 = new PreciousResource(2);
		PreciousResource res3 = new PreciousResource(3);
		try {
			if (ThreadLocalRandom.current().nextBoolean())
			   throw new IllegalArgumentException("Ooopps...");
		}finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}		
	}
	public static void sun() { // Java SE 7: try with resources
		try (
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);
				) {
			//if (ThreadLocalRandom.current().nextBoolean())
				throw new IllegalArgumentException("Ooopps...");

		}catch (Exception e) {
			System.err.println("%s: %s".formatted(e.getClass().getSimpleName(),e.getMessage()));
			for(Throwable se : e.getSuppressed()) {
				System.err.println("%s: %s".formatted(se.getClass().getSimpleName(),se.getMessage()));
			}
		}		
	}
	
	public static void main(String[] args) {
		sun();
	}

}

class PreciousResource implements Closeable {
	private final int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void close() throws IOException {
		System.out.println("Closing the resource (%d)".formatted(id));
		throw new IOException("Something is wrong while closing the resource (%d).".formatted(id));
	}
	
}
