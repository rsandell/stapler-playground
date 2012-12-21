def l = namespace(lib.LayoutTagLib)
st = namespace("jelly:stapler")

l.layout(title: "Testing") {
    form(action: "newSubmit", method: "POST") {
        fieldset() {
            legend(_("title", _("New Item")))
            label(_("Name"))
            input(type: "text", name: "name", placeholder: _("Type a name..."))
            span(class: "help-block", _("Some help text."))
            button(type: "submit", class: "btn", _("Create"))
        }
    }
}