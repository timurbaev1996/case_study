/*
INSERT INTO counterparty (counterparty_id,counterparty_name, counterparty_status, counterparty_date_registered)
VALUES (2,"Richard", "B", '2003-01-01 00:00:00');
*/
/*
INSERT INTO instrument (instrument_id, instrument_name)
VALUES (1,'Astronomica');

INSERT INTO instrument (instrument_id, instrument_name)
VALUES (2,'Deuteronic');
*/

INSERT INTO deal (deal_id, deal_time, deal_counterparty_id, deal_instrument_id, deal_type, deal_amount, deal_quantity)
VALUES (2001, '2018-07-30T05:58:20.915', 1, 1, 'S', 3405.29, 6);

INSERT INTO deal (deal_id, deal_time, deal_counterparty_id, deal_instrument_id, deal_type, deal_amount, deal_quantity)
VALUES (2002, '2018-07-30T05:58:20.915', 2,2, 'B', 8531.05, 28);