<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr><td>
    <a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
  </td></tr>
</table>

<div align="center">
  <p>
    <b>Please confirm the information below and then press continue...</b>
  </p>
  <p></p>
  <table class="n13">
    <tr>
      <td align="center" colspan="2">
        <font size="4"><b>Order</b></font><br />
        <font size="3">
          <b><fmt:formatDate value="${orderForm.order.orderDate}" 
            pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="GREEN" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td>${orderForm.order.billToFirstName}</td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td>${orderForm.order.billToLastName}</td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td>${orderForm.order.billingAddress.addr1}</td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td>${orderForm.order.billingAddress.addr2}</td>
    </tr>
    <tr>
      <td>City:</td>
      <td>${orderForm.order.billingAddress.city}</td>
    </tr>
    <tr>
      <td>State:</td>
      <td>${orderForm.order.billingAddress.state}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${orderForm.order.billingAddress.zip}</td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>${orderForm.order.billingAddress.country}</td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="GREEN" size="4"><b>Shipping Address</b></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td>${orderForm.order.shipToFirstName}</td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td>${orderForm.order.shipToLastName}</td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td>${orderForm.order.shippingAddress.addr1}</td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td>${orderForm.order.shippingAddress.addr2}</td>
    </tr>
    <tr>
      <td>City:</td>
      <td>${orderForm.order.shippingAddress.city}</td>
    </tr>
    <tr>
      <td>State:</td>
      <td>${orderForm.order.shippingAddress.state}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${orderForm.order.shippingAddress.zip}</td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>${orderForm.order.shippingAddress.country}</td>
    </tr>
  </table>
  <p>
    <a href='<c:url value="/shop/confirmOrder.do"/>'>
      <img border="0" src="../images/button_continue.gif" alt="" /></a>
  </p>
</div>

<%@ include file="IncludeBottom.jsp"%>
