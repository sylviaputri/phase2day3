<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Drivers List</h4>
            <ul>
                <li v-for="(driver, index) in drivers" :key="index">
                    <router-link :to="{
                            name: 'driver-details',
                            params: { driver: driver, id: driver.id }
                        }">
                            {{driver.name}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "drivers-list",
  data() {
    return {
      drivers: []
    };
  },
  methods: {
    retrieveDrivers() {
      http
        .get("/drivers")
        .then(response => {
          this.drivers = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveDrivers();
    }
  },
  mounted() {
    this.retrieveDrivers();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
