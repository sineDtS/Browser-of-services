import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServiceServerImpl extends UnicastRemoteObject implements InterfacesForRMIBrowser.ServiceServer {
    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new InterfacesForRMIBrowser.DiceService());
        serviceList.put("Visual Music Service", new InterfacesForRMIBrowser.MiniMusicService());
        serviceList.put("Day of week Service", new InterfacesForRMIBrowser.DayOfTheWeekService());
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public InterfacesForRMIBrowser.Service getService(Object serviceKey) throws RemoteException {
        InterfacesForRMIBrowser.Service theService = (InterfacesForRMIBrowser.Service) serviceList.get(serviceKey);
        return theService;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {e.printStackTrace();}
        System.out.println("Remote service is running");
    }
}
