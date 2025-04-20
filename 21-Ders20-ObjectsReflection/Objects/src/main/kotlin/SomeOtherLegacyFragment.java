import org.example.HomeFragment;

import java.util.ArrayList;

public class SomeOtherLegacyFragment {
    public static void main(String[] args) {
        HomeFragment.MyCompanion.newInstance(new ArrayList<>());
    }
}
