select count(*) as FISH_COUNT, Month(time) as MONTH
from FISH_INFO
group by MONTH
order by MONTH