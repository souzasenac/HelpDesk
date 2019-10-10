package br.senac.es.helpdesk.model;

public enum  Status {
    FECHADO {
        @Override
        public String toString() {
            return "FECHADO";
        }
    },
    ABERTO{
        @Override
        public String toString() {
            return "ABERTO";
        }
    };
}