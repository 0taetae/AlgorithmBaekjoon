SELECT DISTINCT milk.CART_ID
FROM CART_PRODUCTS milk
JOIN (SELECT *
      FROM CART_PRODUCTS
      WHERE NAME = 'Yogurt'
      ) yogurt
ON milk.CART_ID = yogurt.CART_ID
where milk.NAME = 'milk'