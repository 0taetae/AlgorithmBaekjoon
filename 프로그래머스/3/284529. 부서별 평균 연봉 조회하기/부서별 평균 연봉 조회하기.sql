select he.DEPT_ID, DEPT_NAME_EN, round(avg(SAL),0) as AVG_SAL
from HR_DEPARTMENT hd join HR_EMPLOYEES he
on hd.DEPT_ID = he.DEPT_ID
group by he.DEPT_ID
order by AVG_SAL DESC