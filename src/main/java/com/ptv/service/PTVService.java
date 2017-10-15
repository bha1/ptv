package com.ptv.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptv.adapter.PTVAdapter;
import com.ptv.entity.IDirectionDOA;
import com.ptv.entity.IRouteDAO;
import com.ptv.entity.Route;
import com.ptv.entity.RouteId;
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
	
	@Autowired IDirectionDOA directionDOA;
	
	@Override
	public String beginInit() {
		String response = null;
		try {
		PTVAdapter adapter = new PTVAdapter();
		//clear routes
		ArrayList<Route> routeList = (ArrayList<Route>) routeDAO.getAllRoutes();
		for(Route route : routeList) {
			//routeDAO.deleteRoute(new RouteId(route.getRoute_type(), route.getRoute_id()));
			routeDAO.deleteRoute(route);
		}
		
		//load routes
		ArrayList<Route> list = adapter.getRoutes();
		routeDAO.addRouteAll(list);
		for(Route route : list) {
			System.out.println(route.getRoute_id());
			directionDOA.addDirectionAll(adapter.getDirection(route.getRoute_id()));
		}
		
		System.out.println(routeDAO.getRouteByrouteId("1880").getRoute_name());
		//load directions
		
		
		response = "init call success";
		}catch(Exception e){
			e.printStackTrace();
			response = "init call failed";
		}
		return response;
	}
	
	@Override
	public void listRoutes() {
		
	}
}
