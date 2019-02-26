/*
Because a product can be sold at a discount, 
we want to know the highest unit price ever 
sold for each product.
 
This query uses correlated subquery to get
the highest unit price for each product sold. 
 
Alias is used for order_details in both the
subquery and outer query.
*/
select distinct a.ProductID, 
       a.UnitPrice as Max_unit_price_sold
from order_details as a
where a.UnitPrice = 
(
    select max(UnitPrice)
    from order_details as b
    where a.ProductID = b.ProductID
)
order by a.ProductID;
 
/*
This query returns the exact same result as the one above. 
It uses inner join to rephrase the query above and 
the query performance is dramatically improved.
*/
select distinct a.ProductID, a.UnitPrice as Max_unit_price_sold
from order_details as a
inner join 
(
    select ProductID, max(UnitPrice) as Max_unit_price_sold
    from order_details 
    group by ProductID
) as b
on a.ProductID=b.ProductID and a.UnitPrice=b.Max_unit_price_sold
order by a.ProductID;