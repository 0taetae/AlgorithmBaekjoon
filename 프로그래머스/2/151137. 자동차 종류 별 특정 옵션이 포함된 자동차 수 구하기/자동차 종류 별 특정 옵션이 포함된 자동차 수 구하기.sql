SELECT car_type as CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like '%통풍시트%' OR OPTIONS like '%열선시트%' OR OPTIONS like '%가죽시트%'
group by car_type
ORDER BY car_type