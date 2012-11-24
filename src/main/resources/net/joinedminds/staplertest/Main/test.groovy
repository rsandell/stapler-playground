import net.joinedminds.staplertest.utils.GridMaker
import net.joinedminds.staplertest.model.Item

def l = namespace(lib.LayoutTagLib)
st = namespace("jelly:stapler")

l.layout(title: "Testing") {
    div("class": "row") {
        h1("Testing Wohoo!")
    }
    def grid = new GridMaker<Item>(my.getItems())
    l.grid("grid": grid) {
        st.include("it": col, "page": "listitem.jelly")
    }
}