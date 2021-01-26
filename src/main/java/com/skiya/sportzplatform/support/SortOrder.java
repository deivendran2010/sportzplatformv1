package com.skiya.sportzplatform.support;

import java.util.Objects;

public enum SortOrder {

	DESC("-"), ASC("+");

	private final String symbol;

	private SortOrder(String symbol) {
		this.symbol = symbol;
	}

	public static SortOrder enumOf(String value) {
		if (Objects.isNull(value)) {
			return DESC;
		}

		for (SortOrder order : values()) {
			if (order.symbol.contentEquals(value)) {
				return order;
			}
		}

		return DESC;
	}
}
