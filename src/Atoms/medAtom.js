import { atom } from 'recoil';

export const medList = atom({
    key: 'medList',
    default: [
        {
            medicineName: 'paracetamol',
            dose: '500mg',
            stock: '30',
            time: '4:10',
            monday: false,
            tuesday: false,
            wednesday: false,
            thursday: false,
            friday: false,
            saturday: false,
            sunday: false,
            hour: 0,
            minute: 0,
        },
    ],
});
