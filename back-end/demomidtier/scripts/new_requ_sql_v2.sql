/* USER REQUIREMENT 3 
FUNCTION : Overview
*/
SELECT d.deal_time, d.deal_type, d.deal_amount, d.deal_quantity, i.instrument_name, c.counterparty_name, c.counterparty_status, c.counterparty_date_registered
FROM deal d, counterparty c, instrument i
where d.deal_instrument_id = i.instrument_id and d.deal_counterparty_id = c.counterparty_id
order by d.deal_id;

/* USER REQUIREMENT 4 
FUNCTION: Correalation
*/

/* Correlation btw. deal_type and counterparty --> SHows the most frequently traded Counterparty */
SELECT sum(d.deal_quantity), sum(d.deal_amount), c.counterparty_name
	FROM deal d, counterparty c
    WHERE d.deal_counterparty_id = c.counterparty_id
    group by c.counterparty_name;
    
/* Correlation btw. deal_amount, deal_quantity and instrument --> Shows which instruments traded the most with the highest amount */
SELECT sum(d.deal_quantity), sum(d.deal_amount), i.instrument_name
	FROM deal d, instrument i
    WHERE d.deal_instrument_id = i.instrument_id
    group by i.instrument_name;


/* NEW REQUIREMENTS */

/* Requirement 1 
What are the average buy and sell prices for each instrument during the period? - importance (3), accuracy (4)
FUNCTION: Average_price
*/
SELECT i.instrument_name, AVG(d.deal_amount * d.deal_quantity) AS avg_sell_price
  FROM deal d, instrument i
  WHERE d.deal_type = 'S' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name;

SELECT i.instrument_name, AVG(d.deal_amount * d.deal_quantity) AS avg_sell_price
  FROM deal d, instrument i
  WHERE d.deal_type = 'B' 
  AND d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name;
  
/* Requirement 2
What are the dealers ending positions (i.e. how many net trades have they done on each instrument)? - importance (4), accuracy (5)
FUNCTION: End_Position
*/

select  c.counterparty_name, i.instrument_name, SUM(case when d.deal_type = 'S' then d.deal_quantity else 0 end) - SUM(case when d.deal_type = 'B' then d.deal_quantity else 0 end) as net_trade
FROM  deal d
INNER JOIN counterparty c on d.deal_counterparty_id = c.counterparty_id 
INNER JOIN instrument i on  d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name, c.counterparty_name;
  

/* Requirement 3
What is the realised profit/loss for each dealer (i.e. net sum of their trade values)? - importance (3), accuracy (5)
FUNCTION: Realised_Profit
*/

select  c.counterparty_name, i.instrument_name, 
(SUM(case when d.deal_type = 'S' then d.deal_amount * d.deal_quantity else 0 end))
- 
(SUM(case when d.deal_type = 'B' then d.deal_amount *d.deal_quantity else 0 end) )
as realised_result
FROM  deal d
INNER JOIN counterparty c on d.deal_counterparty_id = c.counterparty_id 
INNER JOIN instrument i on  d.deal_instrument_id = i.instrument_id
  Group by i.instrument_name, c.counterparty_name;  



/* Requirement 4
What is the effective profit/loss for each dealer (i.e. resolving their positions using the ending buy/sell price)? - importance (4), accuracy (5)
??????????????????????
*/
select  i.instrument_name, (SUM(case when d.deal_type = 'S' then d.deal_amount * d.deal_quantity else 0 end) - SUM(case when d.deal_type = 'B' then d.deal_amount *d.deal_quantity else 0 end)) + (SUM(case when d.deal_type = 'S' then d.deal_quantity else 0 end) - SUM(case when d.deal_type = 'B' then d.deal_quantity else 0 end)) * (CASE WHEN i.instrument_name = 'Astronomica' THEN 2657.01 WHEN i.instrument_name = 'Borealis' THEN 6090.83 WHEN i.instrument_name = 'Celestial' THEN 1099.1 WHEN i.instrument_name = 'Deuteronic' THEN 3131.3 WHEN i.instrument_name = 'Eclipse' THEN 8913.57 WHEN i.instrument_name = 'Floral' THEN 507.72 WHEN i.instrument_name = 'Galactia' THEN 6574.05 WHEN i.instrument_name = 'Heliosphere' THEN 9025.46 WHEN i.instrument_name = 'Interstella' THEN 2485.94 WHEN i.instrument_name = 'Jupiter' THEN 4613.63 WHEN i.instrument_name = 'Koronis' THEN 2314.43 WHEN i.instrument_name = 'Lunatic' THEN 1235.49 ELSE 1000 END) as effective_result FROM  deal d INNER JOIN instrument i on  d.deal_instrument_id = i.instrument_id Group by i.instrument_name;  



