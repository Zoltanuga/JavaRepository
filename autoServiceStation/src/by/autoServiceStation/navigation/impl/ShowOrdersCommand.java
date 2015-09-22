package by.autoServiceStation.navigation.impl;

import by.autoServiceStation.navigation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.autoServiceStation.resources.constants.Constants.ADD_ORDER_PAGE;

public class ShowOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ADD_ORDER_PAGE;
    }
}
