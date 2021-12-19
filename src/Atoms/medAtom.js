import { atom } from 'recoil';

export const medList = atom({
    key: 'medList',
    default: [
        { name: 'paracetamol', dose: '500mg', stock: '30', time: '4:10' },
    ],
});
