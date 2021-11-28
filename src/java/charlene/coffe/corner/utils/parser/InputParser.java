package charlene.coffe.corner.utils.parser;

import charlene.coffe.corner.data.MenuItemTemplate;
import charlene.coffe.corner.data.menu.items.MenuItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputParser {

    private static final String SEPARATOR = ", ";

    public static final List<MenuItem> parseInputItems(String itemList) {
        if(itemList == null || itemList.isBlank()) return Collections.emptyList();
        return Arrays.stream(itemList.split(SEPARATOR))
                .map(MenuItemTemplate::menuItemOfString)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
