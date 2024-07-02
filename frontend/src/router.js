
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LoanLoanManager from "./components/listers/LoanLoanCards"
import LoanLoanDetail from "./components/listers/LoanLoanDetail"

import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"


import BookBookManager from "./components/listers/BookBookCards"
import BookBookDetail from "./components/listers/BookBookDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/loans/loans',
                name: 'LoanLoanManager',
                component: LoanLoanManager
            },
            {
                path: '/loans/loans/:id',
                name: 'LoanLoanDetail',
                component: LoanLoanDetail
            },

            {
                path: '/members/members',
                name: 'MemberMemberManager',
                component: MemberMemberManager
            },
            {
                path: '/members/members/:id',
                name: 'MemberMemberDetail',
                component: MemberMemberDetail
            },


            {
                path: '/books/books',
                name: 'BookBookManager',
                component: BookBookManager
            },
            {
                path: '/books/books/:id',
                name: 'BookBookDetail',
                component: BookBookDetail
            },



    ]
})
