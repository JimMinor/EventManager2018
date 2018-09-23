package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public  enum TipologiaEnum {

    MUSICALE{
        public List<String> getListaGeneri(){
            List<String> list = new ArrayList<>();
            for(GenereMusicaleEnum genere : GenereMusicaleEnum.values())
                list.add(genere.name());
            return list;
        }
    },
    TEATRO{
        public List<String> getListaGeneri(){
            List<String> list = new ArrayList<>();
            for(GenereTeatroEnum genere : GenereTeatroEnum.values())
                list.add(genere.name());
            return list;
        }
    },
    SPORTIVO{
        public List<String> getListaGeneri(){
        List<String> list = new ArrayList<>();
        for(SportEnum genere : SportEnum.values())
            list.add(genere.name());
        return list;
    }},
    MANIFESTAZIONI{
        public List<String> getListaGeneri(){
        List<String> list = new ArrayList<>();
        for(GenereManifestazioneEnum genere : GenereManifestazioneEnum.values())
            list.add(genere.name());
        return list;
    } };

    public List<String> getListaGeneri(){
        List<String> list = new ArrayList<>();
        list.addAll(MANIFESTAZIONI.getListaGeneri());
        list.addAll(SPORTIVO.getListaGeneri());
        list.addAll(MUSICALE.getListaGeneri());
        list.addAll(TEATRO.getListaGeneri());
        return list;
    }

}
