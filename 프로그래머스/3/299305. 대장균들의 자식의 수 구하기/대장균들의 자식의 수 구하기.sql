SELECT child.ID, count(parent.ID) AS CHILD_COUNT
from ECOLI_DATA child
left join ECOLI_DATA parent
on child.ID = parent.PARENT_ID
group by child.ID
order by child.ID