<template>
    <div id="list">
        <div class="item" v-for="item in  list" :key="item.bookId">
            <div class="img">
                <img :src="item.imgUrl">
            </div>
            <div class="detail">
                <h5 class="title">{{item.title}}</h5>
                <div class="status">
                    订单已完成
                </div>
                <div class="footer">
                    <span class="price">
                        ¥{{item.price}}
                    </span>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            list:[{                    
                "bookId":1,
                "price":20.00,
                "title":'titlefgfkhgjfgjhl',
                'imgUrl':'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iOTgiIGhlaWdodD0iMTUwIiB2aWV3Qm94PSIwIDAgOTggMTUwIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPgo8dGl0bGU+ZHVvaHVpLWVsZW1lbnQ8L3RpdGxlPgo8ZGVzYz5DcmVhdGVkIHVzaW5nIEZpZ21hPC9kZXNjPgo8ZyBpZD0iQ2FudmFzIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMjIxNiAxNDApIj4KPGNsaXBQYXRoIGlkPSJjbGlwLTAiIGNsaXAtcnVsZT0iZXZlbm9kZCI+CjxwYXRoIGQ9Ik0gMjIxNiAtMTQwTCAyMzE0IC0xNDBMIDIzMTQgMTBMIDIyMTYgMTBMIDIyMTYgLTE0MFoiIGZpbGw9IiNGRkZGRkYiLz4KPC9jbGlwUGF0aD4KPGcgaWQ9ImR1b2h1aS1lbGVtZW50IiBjbGlwLXBhdGg9InVybCgjY2xpcC0wKSI+CjxwYXRoIGQ9Ik0gMjIxNiAtMTQwTCAyMzE0IC0xNDBMIDIzMTQgMTBMIDIyMTYgMTBMIDIyMTYgLTE0MFoiIGZpbGw9IiNGRkZGRkYiLz4KPGcgaWQ9IkR1b2h1aSBJY29uIDIiPgo8ZyBpZD0iVmVjdG9yIj4KPHVzZSB4bGluazpocmVmPSIjcGF0aDBfZmlsbCIgdHJhbnNmb3JtPSJtYXRyaXgoMS4yNjYzNiAwIDAgMS4yMTkyOSAyMjMwIC03NS43MDM4KSIgZmlsbD0iIzNBODhGRCIvPgo8L2c+CjxnIGlkPSJWZWN0b3IiPgo8dXNlIHhsaW5rOmhyZWY9IiNwYXRoMV9maWxsIiB0cmFuc2Zvcm09Im1hdHJpeCgxLjQxNTM0IDAgMCAxLjIxODM0IDIyMjYgLTExMikiIGZpbGw9IiMzNUFGRkIiLz4KPC9nPgo8L2c+CjwvZz4KPC9nPgo8ZGVmcz4KPHBhdGggaWQ9InBhdGgwX2ZpbGwiIGZpbGwtcnVsZT0iZXZlbm9kZCIgZD0iTSAyNS43NzIyIDEuMDA2MzVDIDI2LjIgMC4zNzQ5ODMgMjYuODk0OSAtMi42NjEzZS0wNyAyNy42MzQ5IC0yLjY2MTNlLTA3QyAyOC4zNzU1IC0yLjY2MTNlLTA3IDI5LjA2OTkgMC4zNzQ5ODMgMjkuNDk4MyAxLjAwNjM1QyAzNC40MDkgOC4yNDk2NCA0Ny43OTggMjcuOTk2NCA1NC41OTg2IDM4LjAyNjJDIDU1LjM4NzggMzkuMTkwMSA1NS40ODk2IDQwLjcxNjIgNTQuODYyMyA0MS45ODNDIDU0LjIzNSA0My4yNDk4IDUyLjk4MzMgNDQuMDQ1MiA1MS42MTc4IDQ0LjA0NTJDIDM5LjY2OTQgNDQuMDQ1MiAxNS42MDEgNDQuMDQ1MiAzLjY1MjEgNDQuMDQ1MkMgMi4yODcxMiA0NC4wNDUyIDEuMDM1NDUgNDMuMjQ5OCAwLjQwODE3MyA0MS45ODNDIC0wLjIxOTEwNiA0MC43MTYyIC0wLjExNzM1MyAzOS4xOTAxIDAuNjcxODA0IDM4LjAyNjJDIDcuNDcyNDIgMjcuOTk2NCAyMC44NjA5IDguMjQ5NjQgMjUuNzcyMiAxLjAwNjM1WiIvPgo8cGF0aCBpZD0icGF0aDFfZmlsbCIgZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNIDI0Ljk5MzkgMS40NDcwM0MgMjUuNjEzNyAwLjUzMzExNyAyNi41NTcyIC0zLjAxNjE0ZS0wNyAyNy41NTUxIC0zLjAxNjE0ZS0wN0MgMjguNTUzNSAtMy4wMTYxNGUtMDcgMjkuNDk3IDAuNTMzMTE3IDMwLjExNjggMS40NDcwM0MgMzUuNDY3NCA5LjMzODU0IDQ3Ljg3MjUgMjcuNjM0MiA1NC40MDQzIDM3LjI2ODFDIDU1LjE4MjUgMzguNDE1NyA1NS4zMjk5IDM5Ljk4MiA1NC43ODQ3IDQxLjI5OTlDIDU0LjIzODkgNDIuNjE4NSA1My4wOTYgNDMuNDU1NiA1MS44NDI2IDQzLjQ1NTZDIDM5LjkwMjMgNDMuNDU1NiAxNS4yMDg0IDQzLjQ1NTYgMy4yNjgxMSA0My40NTU2QyAyLjAxNDcxIDQzLjQ1NTYgMC44NzE3MzkgNDIuNjE4NSAwLjMyNTk3OCA0MS4yOTk5QyAtMC4yMTk3ODMgMzkuOTgyIC0wLjA3MTc4MTMgMzguNDE1NyAwLjcwNjM5IDM3LjI2ODFDIDcuMjM4MTggMjcuNjM0MiAxOS42NDMzIDkuMzM4NTQgMjQuOTkzOSAxLjQ0NzAzWiIvPgo8L2RlZnM+Cjwvc3ZnPgo='
            }]
        }
    }
}
</script>
<style lang="stylus" scoped>
    #list
        .item
            display flex
            box-sizing border-box
            height 2.2rem
            padding .1rem
            border-bottom .02rem solid #c6c6c6
            .img
                img
                    padding  0rem .2rem
                    width  1.6rem
                    height 2.0rem
            .detail
                flex 1
                display flex
                padding .1rem .2rem
                box-sizing border-box
                overflow hidden
                flex-direction column
                .title
                    font-size .36rem
                    line-height .48rem
                    padding-bottom .1rem
                    overflow hidden
                    word-break break-word
                .status
                    line-height .48rem
                    font-size .36rem
                .footer
                    padding-top .2rem
                    .price
                        color #f56c6c                      
</style>
