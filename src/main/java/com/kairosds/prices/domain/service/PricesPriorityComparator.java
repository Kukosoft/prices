package com.kairosds.prices.domain.service;

import java.util.Comparator;

import com.kairosds.prices.domain.Price;

public class PricesPriorityComparator implements Comparator<Price> {

	@Override
	public int compare(Price p1, Price p2) {
		return p1.getPriority().compareTo(p2.getPriority());
	}

}
