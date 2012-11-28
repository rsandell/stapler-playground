import net.joinedminds.staplertest.utils.GridMaker
import net.joinedminds.staplertest.model.Item

def l = namespace(lib.LayoutTagLib)
st = namespace("jelly:stapler")

l.layout(title: "Testing") {
    div("class": "row") {
        h1("Testing Wohoo!")
    }
    def grid = new GridMaker<Item>(my.getItems(), 6)
    l.grid("grid": grid, "spanClass": "span2") {
        st.include("it": col, "page": "listitem.jelly")
    }
}