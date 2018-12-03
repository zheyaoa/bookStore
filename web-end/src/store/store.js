import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    list:[
    ]
  },
  mutations: {
    addList(state,item){
      let includes =false;
      for(var i = 0;i<state.list.length;i++){
        if(state.list[i].cId == item.cId){
          includes = true;
          break;
        }
      }
      if(!includes){
        item.num = 1;
        item.checked = false;
        state.list.push(item);
      }
    },
    updateList(state,list){
      state.list = list;
    }
  },
  actions: {

  }
})
