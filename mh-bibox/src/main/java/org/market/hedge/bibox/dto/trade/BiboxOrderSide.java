package org.market.hedge.bibox.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.exceptions.ExchangeException;

/** @author odrotleff */
public enum BiboxOrderSide {
  BID(1, OrderType.BID),
  ASK(2, OrderType.ASK),
  EXIT_BID(3,OrderType.EXIT_BID),
  EXIT_ASK(4,OrderType.EXIT_ASK);

  private int orderSide;
  private OrderType orderType;

  private BiboxOrderSide(int orderSide, OrderType orderType) {
    this.orderSide = orderSide;
    this.orderType = orderType;
  }

  public static BiboxOrderSide fromOrderType(OrderType orderType) {
    switch (orderType) {
      case BID:
        return BiboxOrderSide.BID;
      case ASK:
        return BiboxOrderSide.ASK;
      case EXIT_BID:
        return BiboxOrderSide.EXIT_BID;
      case EXIT_ASK:
        return BiboxOrderSide.EXIT_ASK;
      default:
        throw new ExchangeException("Order type " + orderType + " unsupported.");
    }
  }

  @JsonCreator
  public static BiboxOrderSide fromInt(int orderSide) {
    switch (orderSide) {
      case 1:
        return BID;
      case 2:
        return ASK;
      default:
        throw new ExchangeException("Unexpected Bibox order side.");
    }
  }

  public int asInt() {
    return orderSide;
  }

  public OrderType getOrderType() {
    return orderType;
  }
}
