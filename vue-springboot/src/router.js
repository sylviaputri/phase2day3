import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
import AddCustomer from "./components/AddCustomer.vue";
import SearchCustomers from "./components/SearchCustomers.vue";
import Customer from "./components/Customer.vue";
import DriversList from "./components/DriversList.vue";
import Driver from "./components/Driver.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList,
      children: [
        {
          path: "/customer/:id",
          name: "customer-details",
          component: Customer,
          props: true
        }
      ]
    },
    {
      path: "/add",
      name: "add",
      component: AddCustomer
    },
    {
      path: "/search",
      name: "search",
      component: SearchCustomers
    },
    {
      path: "/drivers",
      name: "drivers",
      alias: "/driver",
      component: DriversList,
      children: [
        {
          path: "/driver/:id",
          name: "driver-details",
          component: Driver,
          props: true
        }
      ]
    }
  ]
});