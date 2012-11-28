package net.joinedminds.staplertest.model.Item

import net.joinedminds.staplertest.model.Item
import net.joinedminds.staplertest.Functions;

def l = namespace(lib.LayoutTagLib)
st = namespace("jelly:stapler")

l.layout(title: "[Item]    " + my.getName(), contextMenu: Functions.DEFAULT_ITEM_CONTEXT_MENU) {
    h1(my.getName())
}