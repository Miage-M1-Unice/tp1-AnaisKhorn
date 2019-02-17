package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class FilterRegex implements FilenameFilter {
    private Pattern p;

    public FilterRegex (){
        p = Pattern.compile(".*xml");
    }

    @Override
    public boolean accept(File dir, String name) {
        return p.matcher(new File(name).getName()).matches();
    }
}
