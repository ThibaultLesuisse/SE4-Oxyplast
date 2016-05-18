
package be.odisee.oxyplast.dao;

import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


class HibernateDao {

    SessionFactory sessionFactory;

    protected HibernateDao() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void sessionSaveObject(Object o){
        try{
            sessionFactory.getCurrentSession().save(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Object sessionGetObjectById(String classname, int id){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname + " where id="+id).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object getLastObjectOfQuery(String qstr){
        Object result = null;
        try{
            @SuppressWarnings("rawtypes")
			List list = sessionFactory.getCurrentSession().createQuery(qstr).list();
            // als er geen objecten in het resultaat zitten, retourneren we result = null
            if (!list.isEmpty()) result = list.get(list.size()-1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectBy1StringParameterNamedQuery(String qstr, String parameter, String value){

        // geeft een antlr probleem .. voorlopig is er geen oplossing voor

        Query query = null;
        Object result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery(qstr);
            query.setString(parameter, value);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectByQuery(String qstr){

        // work arround omdat vorige niet werkt

        Object result = null;
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(qstr);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
	protected List sessionGetAllObjects(String classname) {
        Query query = null;
 		List result = null;
        try{
        	System.out.println("DEBUG DAO update: "+classname);
            query = sessionFactory.getCurrentSession().createQuery("from "+classname);
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @SuppressWarnings("rawtypes")
   	protected List sessionGetAllObjectsById(String classname, String parameter, int value) {
           Query query = null;
    		List result = null;
           try{
           	System.out.println("DEBUG DAO update: "+classname);
               query =  sessionFactory.getCurrentSession().createQuery("from "+classname+" where "+parameter+" = "+value);
               result = query.list();
           }
           catch (Exception e){
               e.printStackTrace();
           }
           return result;
       }
    
    protected void sessionUpdateObject(Object o){
        try{
       	sessionFactory.getCurrentSession().saveOrUpdate(o);
        sessionFactory.getCurrentSession().flush();
       	System.out.println("DEBUG DAO update: "+o.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            
        }

    }
    protected Object sessionGetObjectByStringParameterValue(String classname, String parameter, String value){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname+" where "+parameter+"='"+value+"'").uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }  

    protected void sessionDeleteObject(Object o){
    	try{
    		sessionFactory.getCurrentSession().evict(o);
    		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().contains(o) ? o : sessionFactory.getCurrentSession().merge(o));
    		sessionFactory.getCurrentSession().flush();   		
            System.out.println("DEBUG DAO delete: "+o.toString());
           
        }
        catch (Exception e){
            e.printStackTrace();
        }
    	
    }
    protected boolean sessionDeleteById(Class<?> type, Serializable id) {
        Object persistentInstance = sessionFactory.getCurrentSession().load(type, id);
        if (persistentInstance != null) {
        	sessionFactory.getCurrentSession().delete(persistentInstance);
            return true;
        }
        return false;
    }
    

}
