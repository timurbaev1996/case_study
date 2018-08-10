INSERT INTO db_grad_cs_1917.counterparty (
    counterparty_name,
    counterparty_status,
	counterparty_date_registered
) 
SELECT
    DISTINCT counterparty_name,
    counterparty_status,
	counterparty_date_registered
FROM db_grad.deal;

INSERT INTO db_grad_cs_1917.instrument (
    instrument_name
) 
SELECT
	DISTINCT instrument_name
FROM db_grad.deal;


INSERT INTO db_grad_cs_1917.deal (
	deal_id, 
    deal_time,
    deal_counterparty_id,
    deal_instrument_id,
    deal_type,
    deal_amount,
    deal_quantity
) 
SELECT
	d.deal_id,
	STR_TO_DATE(d.deal_time, "%Y-%m-%dT0%h:%i:%s.%f"),
    c.counterparty_id,
    i.instrument_id,
	d.deal_type,
	d.deal_amount,
	d.deal_quantity
FROM db_grad.deal d, db_grad_cs_1917.counterparty c, db_grad_cs_1917.instrument i
WHERE d.counterparty_name = c.counterparty_name
AND d.instrument_name = i.instrument_name;

