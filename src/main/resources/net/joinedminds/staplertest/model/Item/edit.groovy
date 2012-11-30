package net.joinedminds.staplertest.model.Item

import net.joinedminds.staplertest.model.Item
import net.joinedminds.staplertest.Functions;

def l = namespace(lib.LayoutTagLib)
st = namespace("jelly:stapler")

l.layout(title: "[Edit Item]    " + my.getName()) {
    form(action: "editSubmit", method: "POST") {
        fieldset() {
            legend(_("title", my.getName()))
            label(_("Name"))
            input(type: "text", name: "name", value: my.getName(), placeholder: _("Type a name..."))
            span(class: "help-block", _("Some help text."))
            label(_("Description"))
            textarea(rows: 3, name: "description", my.getDescription())
            span(class: "help-block", _("Something nice."))
            button(type: "submit", class: "btn", _("Save"))
        }
    }
}
