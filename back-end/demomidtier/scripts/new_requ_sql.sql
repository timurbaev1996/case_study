/* USER REQUIREMENT 3 */
SELECT * FROM deal;
SELECT * FROM counterparty;
SELECT * FROM instrument;

/* USER REQUIREMENT 4 */

/* Correlation btw. deal_type and counterparty --> SHows the most frequently traded Counterparty */
SELECT d.deal_type, d.deal_quantity, d.deal_amount, c.counterparty_name
	FROM deal d, counterparty c
    WHERE d.deal_counterparty_id = c.counterparty_id;
    
/* Correlation btw. deal_amount, deal_quantity and instrument --> Shows which instruments traded the most with the highest amount */
SELECT d.deal_type, d.deal_quantity, d.deal_amount, i.instrument_name
	FROM deal d, instrumnet i
    WHERE d.deal_instrument_id = i.instrument_id;


/* NEW REQUIREMENTS */

/* Requirement 1 
What are the average buy and sell prices for each instrument during the period? - importance (3), accuracy (4)
*/
SELECT AVG(d.deal_amount) AS avg_sell_price, i.instrument_name
  FROM deal d, instrument i
  WHERE d.deal_type = 'S' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name;

SELECT AVG(d.deal_amount) AS avg_sell_price, i.instrument_name
  FROM deal d, instrument i
  WHERE d.deal_type = 'B' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name;
  
/* Requirement 2
What are the dealers ending positions (i.e. how many net trades have they done on each instrument)? - importance (4), accuracy (5)
*/

SELECT SUM(d.deal_quantity) AS end_position_sell, i.instrument_name
  FROM deal d, instrument i
  WHERE d.deal_type = 'S' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name; 
  
  
SELECT SUM(d.deal_quantity) AS end_position_buy, i.instrument_name
  FROM deal d, instrument i
  WHERE d.deal_type = 'B' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name;

  
/* end_position_sell - end_position_buy
  

/* Requirement 3
What is the realised profit/loss for each dealer (i.e. net sum of their trade values)? - importance (3), accuracy (5)
*/

  
SELECT SUM(d.deal_amount) AS sum_sell, c.counterparty_name
  FROM deal d, counterparty c
  WHERE d.deal_type = 'S' 
  AND d.deal_counterparty_id = c.counterparty_id
  GROUP BY c.counterparty_name;

SELECT SUM(d.deal_amount) AS sum_buy, c.counterparty_name
  FROM deal d, counterparty c
  WHERE d.deal_type = 'b' 
  AND d.deal_counterparty_id = c.counterparty_id
  GROUP BY c.counterparty_name;
  
/* First Query - Second Query */

/* Requirement 4
What is the effective profit/loss for each dealer (i.e. resolving their positions using the ending buy/sell price)? - importance (4), accuracy (5)
*/




