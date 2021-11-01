package by.viraz84.composite.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;


public class Composite implements Component {

    private final static Logger LOG = LoggerFactory.getLogger(Composite.class);
    private ArrayList<Component> components = new ArrayList<Component>();

    @Override
    public void parse(){
        System.out.println("");
        for (Component component : components) {
            LOG.trace("-----Composite- parse- -component ----- :  {}" , component );
            component.parse();
        }
    }

    public void add(Component component){
        LOG.debug("Composite add component {}", component);
        components.add(component);
    }

    public void remove(Component component){
        LOG.trace("Composite remove component {}", component);
        components.remove(component);
    }

    public int getSize(){
        LOG.trace("Size of the ArrayList {}", components.size());
        return components.size();
    }

    public Object getElem(int index){
        LOG.debug("Composite get component {}", components.get(index));
        return components.get(index);
    }

}
