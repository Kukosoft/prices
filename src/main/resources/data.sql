INSERT INTO BRANDS(NAME) VALUES
  ('Brand1'),
  ('Brand2'),
  ('Brand3');

INSERT INTO PRICES(BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,PRIORITY,PRICE,CURR) VALUES
  (1,TO_DATE('2020-06-14-00.00.00', 'YYYY-MM-DD-HH24.MI.SS'),TO_DATE('2020-12-31-23.59.59', 'YYYY-MM-DD-HH24.MI.SS'),1,35455,0,35.50,'EUR'),
  (1,TO_DATE('2020-06-14-15.00.00', 'YYYY-MM-DD-HH24.MI.SS'),TO_DATE('2020-06-14-18.30.00', 'YYYY-MM-DD-HH24.MI.SS'),2,35455,1,25.45,'EUR'),
  (1,TO_DATE('2020-06-15-00.00.00', 'YYYY-MM-DD-HH24.MI.SS'),TO_DATE('2020-06-15-11.00.00', 'YYYY-MM-DD-HH24.MI.SS'),3,35455,1,30.50,'EUR'),
  (1,TO_DATE('2020-06-15-16.00.00', 'YYYY-MM-DD-HH24.MI.SS'),TO_DATE('2020-12-31-23.59.59', 'YYYY-MM-DD-HH24.MI.SS'),4,35455,1,38.95,'EUR');