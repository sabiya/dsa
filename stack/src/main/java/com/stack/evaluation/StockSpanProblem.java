package com.stack.evaluation;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * The stock span problem is a financial problem where we have a series of n
 * daily price quotes for a stock and we need to calculate span of stock’s price
 * for all n days. 
 * The span Si of the stock’s price on a given day i is defined
 * as the maximum number of consecutive days just before the given day, for
 * which the price of the stock on the current day is less than or equal to its
 * price on the given day. 
 * For example, if an array of 7 days prices is given as
 * {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days
 * are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author sabiya
 *
 */
public class StockSpanProblem {

	@Test
	public void stockSpan() {
		int inputs[] = {100,80,60,70,60,75,85,66,89,90,12,34,56,78,55,76,80,99,15,66,77,22,93,65,87,66,77,33,45,100,55,66,53,98};
//		int inputs[] = {100,80,60,70,60,75,85};
		long start = System.currentTimeMillis();
		int span[] = getStockSpan(inputs, inputs.length);
		long end = System.currentTimeMillis();
		System.out.print("\nCompletion time:" + (end-start)+ " End:" + end + " Start:" + start);
		printArray(span);
		
		long start1 = System.currentTimeMillis();
		int stockspan[] = calculateStockSpan(inputs, inputs.length);
		long end1 = System.currentTimeMillis();
		System.out.print("\nEfficient Method");
		System.out.print("\nCompletion time:" + (end1-start1)+ " End:" + end1 + " Start:" + start1);
		printArray(stockspan);
		System.out.println("\n" + Arrays.equals(span, stockspan));
		assertArrayEquals(span, stockspan);
		
		long start2 = System.currentTimeMillis();
		int stockspaneff[] = calculateStockSpanEff(inputs, inputs.length);
		long end2 = System.currentTimeMillis();
		System.out.print("\nEfficient Method From Geeks:");
		System.out.print("\nCompletion time:" + (end2-start2)+ " End:" + end2 + " Start:" + start2);
		printArray(stockspaneff);
		assertArrayEquals(span, stockspaneff);

		

		
	}
	/**
	 * @param inputs
	 * @param size
	 * @return
	 */
	private int[] getStockSpan(int[] inputs, int size) {
		int [] span = new int [size];
		if (size<=0 || inputs ==null) {
			return span; 
		}

		span[0] = 1;
		for (int i=1; i<size; i++) {
			span[i] =1;
			for (int j=i-1; j>=0 && inputs[j]<= inputs[i] ; j--){
				span[i]++;
			}
		}
		return span;
	}

	/**
	 * @param inputs
	 * @param size
	 * @return
	 */
	public int[] calculateStockSpan(int[] inputs, int size) {
		int [] span = new int [size];
		if (size<=0 || inputs ==null) {
			return span; 
		}
		
		Stack stack = new Stack();
		stack.push(0);
		span[0] = 1;
		for(int j=1;j<size;j++){
			span[j] = 1;
			while(!stack.isEmpty() && (inputs[stack.top()]<= inputs[j]) ) {
				// This 1 line also reduces performance.
				span[j] = span[j] + span[stack.top()];
				stack.pop();
			}
			stack.push(j);
		}
		return span;
	}
	/**
	 * @param inputs
	 * @param size
	 * @return
	 */
	public int[] calculateStockSpanEff(int[] inputs, int size) {
		int [] span = new int [size];
		if (size<=0 || inputs ==null) {
			return span; 
		}
		span[0] =1;
		Stack stack = new Stack();
		stack.push(0);
		for(int j=1;j<size;j++){
			while(!stack.isEmpty()&& (inputs[stack.top()]<= inputs[j])) {
				stack.pop();
			}
			span [j] = (stack.isEmpty()) ? j+1 : j- stack.top();
			stack.push(j);
		}

		return span;
	}

	/**
	 * @param array
	 */
	private void initArraywithVal(int[] array, int val) {
		for(int i=0;i<array.length; i++){
			array[i] = val;
		}

	}
	/**
	 * @param array
	 */
	private void printArray(int[] array) {
		System.out.println();
		for (int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		
	}

}
