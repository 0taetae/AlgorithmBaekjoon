SELECT distinct c.CAR_ID 
from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
on c.CAR_ID = rh.CAR_ID
where c.CAR_TYPE = '세단' and Month(rh.START_DATE)=10
order by c.CAR_ID DESC