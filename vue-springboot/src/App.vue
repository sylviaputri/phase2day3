<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1 v-on:click="showFalse">Ojek Online~</h1>
            <h3>{{authName}}</h3>
        </div>
        <div v-if="isLogin">  
          <nav>
              <router-link class="btn btn-primary" to="/">Customers</router-link>
              <router-link class="btn btn-primary" to="/add">Add</router-link>
              <router-link class="btn btn-primary" to="/search">Search</router-link>
              <router-link class="btn btn-primary" to="/drivers">Drivers</router-link>
          </nav>
          <br/>
          <router-view/>
        </div>
        <div v-else>
          <label style="margin-right:40px">Nama </label>
          <input type="text" ref="inputNama">
          <br/><br/>
          <label style="margin-right:20px">Password </label>
          <input type="password" ref="inputPassword">
          <br/><br/>
          <button v-on:click="clickLogin">LOGIN</button>
        </div>
    </div>
</template>

<script>
import http from "./http-common";

export default {
  name: "app",
  data() {
    return {
      isLogin: false,
      authName : 'Silakan login terlebih dahulu'
    };
  },
  methods: {
    showFalse: function(){
      this.isLogin = true;
    },
    clickLogin: function(){
      const nama = this.$refs.inputNama.value;
      const pass = this.$refs.inputPassword.value;
      http
        .get("/getUserByNameAndPass/"+nama+"/"+pass)
        .then(response => {
          if(response.data.id>0){
            this.authName = response.data.name;
            this.isLogin = true;
          }
          else{
            alert("Nama dan atau password Anda salah, silakan coba lagi :)");
            this.authName = 'Silakan login terlebih dahulu';
          }
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>

<style>
.site-info {
  color: skyblue;
  margin-bottom: 20px;
}

.btn-primary {
  margin-right: 5px;
}

.container-fluid {
  text-align: center;
}

label{
  color: #0099CC;
  font-weight: bold;
}

input[type=text], input[type=password] {
  border: transparent;
  border-bottom:2px solid skyblue; 
}

button{
  color: #0099CC;
  background: transparent; 
  border: 2px solid #0099CC;
  border-radius: 5px;
}

button:hover {
      background-color: #008CBA;
      color: white;
 }
</style>
