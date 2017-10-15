package com.ptv.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptv.adapter.PTVAdapter;
import com.ptv.entity.IRouteDAO;
import com.ptv.entity.Route;
import com.ptv.entity.RouteRepository;

@Service
public class PTVService implements IPTVService{
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
//	
//	@Autowired
//	public PTVService(RouteRepository repository) {
//		// TODO Auto-generated constructor stub
//		this.repository = repository;
//	}
	
//	private RouteRepository repository;
	@Autowired
	private IRouteDAO routeDAO;
	
	@Override
	public void listRoutes() {
		PTVAdapter adapter = new PTVAdapter();
		//adapter.getRoutes();
		
		ArrayList<Route> list = adapter.getRoutes();
		routeDAO.addRouteAll(list);
		for(Route route : list) {
			System.out.println(route.getRoute_id());
//			repository.save(route);
		}
		
	}
}
