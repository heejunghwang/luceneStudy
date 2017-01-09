package org.apache.lucene.analysis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

public class TestCharFilter {

	@Test
	public void testCharFilter1() throws Exception {
		CharFilter cs = new CharFilter1(new StringReader(""));
		assertEquals(1, cs.correctOffset(0));
	}
	
	@Test
	public void testCharFilter2() throws Exception {
		CharFilter cs = new CharFilter2(new StringReader(""));
		assertEquals(2, cs.correctOffset(0));
	}

	static class CharFilter1 extends CharFilter {

		protected CharFilter1(Reader in) {
			super(in);
		}

		@Override
		public int read(char[] cbuf, int off, int len) throws IOException {
			return input.read(cbuf, off, len);
		}

		@Override
		protected int correct(int currentOff) {
			return currentOff + 1;
		}
	}

	static class CharFilter2 extends CharFilter {

		protected CharFilter2(Reader in) {
			super(in);
		}

		@Override
		public int read(char[] cbuf, int off, int len) throws IOException {
			return input.read(cbuf, off, len);
		}

		@Override
		protected int correct(int currentOff) {
			return currentOff + 2;
		}
	}

}
