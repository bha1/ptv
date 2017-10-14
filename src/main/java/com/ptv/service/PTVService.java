package com.ptv.service;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ptv.entity.RouteRepository;
import com.ptv.infra.SessionUtil;

public class PTVService {
//	public void listRoutes() {
//		Session session = SessionUtil.openSession();
//		Transaction tx = null;
//		try{
//			tx=session.getTransaction();
//			//String hql = "FROM Employee e Where e.empNo BETWEEN :empNo1 AND :empNo2";
//			
//		//	TypedQuery<Employee> query = session.createQuery(hql).setParameter("empNo1", 10001).setParameter("empNo2",100001);
////			List<Employee> list = query.getResultList();
////			for(Employee emp : list){
//				//System.out.println(emp.getEmpNo()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getDateOfBirth());
////			}
//			
//			com.ptv.entity.Route rt = new com.ptv.entity.Route();
//			rt.setRouteId("1");
//			rt.setRouteType("1");
//			rt.setRouteName("a to b");
//			rt.setRouteNumber("1");
//			session.save(rt);
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			SessionUtil.closeSession(session);
//		}
//	}
	
	@Autowired
	private RouteRepository routeRepository;
	
	public void listRoutes() {
		
	}
}
