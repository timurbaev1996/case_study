/* USER REQUIRMENT 3 */
SELECT * FROM deal;
SELECT * FROM counterparty;
SELECT * FROM instrument;

/* USER REQUIRMENT 4 
??????????? JOIN 
*/


/* NEW REQUIREMENTS */

/* Requirement 1 
What are the average buy and sell prices for each instrument during the period? - importance (3), accuracy (4)
*/
SELECT AVG(deal_amount) AS avg_sell_price
  FROM deal
  WHERE deal_type = 'S' AND deal_instrument_id = 1; /* Loop through as long as nr_instrument */

SELECT AVG(deal_amount) AS avg_buy_price
  FROM deal
  WHERE deal_type = 'B' AND deal_instrument_id = 1; /* Loop through as long as nr_instrument */
  
SELECT COUNT(instrument_id) AS nr_intsrument
	FROM instrument;
  
/* Requirement 2
What are the dealers ending positions (i.e. how many net trades have they done on each instrument)? - importance (4), accuracy (5)
*/

SELECT COUNT(deal_quantity) AS end_position_sell
  FROM deal
  WHERE deal_type = 'S' AND deal_instrument_id = 1; /* Loop through as long as nr_instrument */
  
SELECT COUNT(deal_quantity) AS end_position_buy
  FROM deal
  WHERE deal_type = 'B' AND deal_instrument_id = 1; /* Loop through as long as nr_instrument */
  
/* end_position_sell - end_position_buy
  
/* First Query - Second Query */

/* Requirement 3
What is the realised profit/loss for each dealer (i.e. net sum of their trade values)? - importance (3), accuracy (5)
*/
SELECT SUM (deal_amount) AS sum_sell
  FROM deal
  WHERE deal_type = 'S' ; 
  
SELECT SUM(deal_amount) AS sum_buy
  FROM deal
  WHERE deal_type = 'B' ; 
  
/* First Query - Second Query */

/* Requirement 4
What is the effective profit/loss for each dealer (i.e. resolving their positions using the ending buy/sell price)? - importance (4), accuracy (5)
*/




