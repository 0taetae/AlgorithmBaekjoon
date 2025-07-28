select YEAR(DIFFERENTIATION_DATE) as YEAR,
        MAX_SIZE_OF_COLONY - SIZE_OF_COLONY as YEAR_DEV, ID
from ECOLI_DATA as ed
left outer join (
    select YEAR(DIFFERENTIATION_DATE) as YEAR, 
            MAX(SIZE_OF_COLONY) AS MAX_SIZE_OF_COLONY
    from ECOLI_DATA
    group by YEAR
) as max_size
on YEAR(ed.DIFFERENTIATION_DATE) = max_size.YEAR
order by YEAR asc, YEAR_DEV asc